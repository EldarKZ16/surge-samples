// Copyright © 2017-2021 UKG Inc. <https://www.ukg.com>

import de.heikoseeberger.sbtheader.HeaderPlugin.autoImport._
import sbt.Keys._
import sbt._

object Settings extends AutoPlugin {
  private val headerSettings = Seq(
    headerLicense := Some(HeaderLicense.Custom("Copyright © 2017-2021 UKG Inc. <https://www.ukg.com>")),
    headerMappings := headerMappings.value ++ Seq(
      HeaderFileType.scala -> HeaderCommentStyle.cppStyleLineComment,
      HeaderFileType.java -> HeaderCommentStyle.cppStyleLineComment))

  override def trigger: PluginTrigger = allRequirements

  override def projectSettings: Seq[Def.Setting[_]] = headerSettings

  override def buildSettings: Seq[Def.Setting[_]] = {
    Seq(scalacOptions ++= Seq("-unchecked", "-deprecation", "-feature"))
  }

}
