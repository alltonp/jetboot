package im.mange.jetpac.page

import net.liftweb.http.LiftRules
import net.liftweb.sitemap._

object Pages {
  def apply(pages: Page*) {
    LiftRules.viewDispatch.append(pages.map(_.view).reduceLeft(_ orElse _))
    LiftRules.setSiteMap(SiteMap(kids = pages.map(_.menuItem()):_*))
  }
}
