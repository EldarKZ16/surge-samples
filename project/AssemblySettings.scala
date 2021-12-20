// Copyright © 2017-2021 UKG Inc. <https://www.ukg.com>

import sbt.{ AutoPlugin, Def, PluginTrigger }
import sbtassembly.AssemblyKeys._
import sbtassembly.AssemblyPlugin.autoImport.{ assembly, MergeStrategy }

object AssemblySettings extends AutoPlugin {
  override def trigger: PluginTrigger = noTrigger

  override def projectSettings: Seq[Def.Setting[_]] = Seq(assemblyMergeStrategy := {
    // Discard module-info.class from jackson.  See https://github.com/sbt/sbt-assembly/issues/391
    case "module-info.class" => MergeStrategy.discard
    case x =>
      val oldStrategy = (assembly / assemblyMergeStrategy).value
      oldStrategy(x)
  })
}
