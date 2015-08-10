package im.mange.jetboot.widget.form

import im.mange.jetboot.widget.form.Validation.Validated
import im.mange.little.amount.Amount
import im.mange.little.percentage.Percentage
import org.joda.time.DateTimeFieldType
import org.joda.time.format.DateTimeFormatterBuilder

import scala.util.{Failure, Success, Try}

class FormReader(formData: FormData) {
  val fieldNames = formData.fieldNames

  def optional(fieldName: String): Option[String] =
    if (formData.valueOf(fieldName).nonEmpty) Some(formData.valueOf(fieldName)) else None

  def asDate(fieldName: String) = toEither(fieldName, ddMMyyyy.parseLocalDate(formData.valueOf(fieldName)))

  def asOptionalDate(fieldName: String) = toEither(fieldName, optional(fieldName) map ddMMyyyy.parseLocalDate)

  def asTime(fieldName: String) = toEither(fieldName, hhmm.parseLocalTime(formData.valueOf(fieldName)))

  def asBigDecimal(fieldName: String) = Right(Try(BigDecimal(formData.valueOf(fieldName))).toOption.getOrElse(BigDecimal("0")))

  def asLong(fieldName: String) = Right(Try(formData.valueOf(fieldName).toLong).toOption.getOrElse(0L))

  def asAmount(fieldName: String) = asString(fieldName).right.map(s => Amount(s))

  def asPercentage(fieldName: String) = Right(Percentage.fromPercentage(formData.valueOf(fieldName)))

  def asString(fieldName: String) = Right(formData.valueOf(fieldName))

  def asBoolean(fieldName: String) = toEither(fieldName, formData.valueOf(fieldName).toBoolean)

  private val ddMMyyyy = new DateTimeFormatterBuilder()
    .appendFixedDecimal(DateTimeFieldType.dayOfMonth, 2)
    .appendLiteral('/')
    .appendFixedDecimal(DateTimeFieldType.monthOfYear, 2)
    .appendLiteral('/')
    .appendYear(4, 4)
    .toFormatter

  private val hhmm = new DateTimeFormatterBuilder()
    .appendFixedDecimal(DateTimeFieldType.hourOfDay(), 2)
    .appendLiteral(':')
    .appendFixedDecimal(DateTimeFieldType.minuteOfHour(), 2)
    .toFormatter

  private def toEither[T](fieldName: String, f: => T): Validated[T] = Try(f) match {
    case Success(t) => Right(t)
    case Failure(x) => Left(Seq(FieldError(fieldName, x.getMessage)))
  }
}

case class FieldError(fieldName: String, message: String)

object Validation {
  type Validated[T] = Either[Seq[FieldError], T]
}
