// Copyright © 2017-2021 UKG Inc. <https://www.ukg.com>

package com.example

import com.example.account.BankAccount
import com.example.command.BankAccountCommand
import com.example.event.BankAccountEvent
import com.example.model.BankAccountSurgeModel
import surge.kafka.KafkaTopic
import surge.scaladsl.command.SurgeCommand

import java.util.UUID

object BankAccountEngine {
  lazy val surgeEngine: SurgeCommand[UUID, BankAccount, BankAccountCommand, BankAccountEvent] = {
    val aggregateName: String = "bank-account"
    val stateTopic: KafkaTopic = KafkaTopic("bank-account-state")
    val eventsTopic: KafkaTopic = KafkaTopic("bank-account-events")
    val engine = SurgeCommand(new BankAccountSurgeModel(aggregateName, stateTopic, eventsTopic))
    engine.start()
    engine
  }
}

object SecondBankAccountEngine {
  lazy val surgeEngine: SurgeCommand[UUID, BankAccount, BankAccountCommand, BankAccountEvent] = {
    val aggregateName: String = "second-bank-account"
    val stateTopic: KafkaTopic = KafkaTopic("second-bank-account-state")
    val eventsTopic: KafkaTopic = KafkaTopic("second-bank-account-events")
    val engine = SurgeCommand(new BankAccountSurgeModel(aggregateName, stateTopic, eventsTopic))
    engine.start()
    engine
  }
}

object ThirdBankAccountEngine {
  lazy val surgeEngine: SurgeCommand[UUID, BankAccount, BankAccountCommand, BankAccountEvent] = {
    val aggregateName: String = "third-bank-account"
    val stateTopic: KafkaTopic = KafkaTopic("third-bank-account-state")
    val eventsTopic: KafkaTopic = KafkaTopic("third-bank-account-events")
    val engine = SurgeCommand(new BankAccountSurgeModel(aggregateName, stateTopic, eventsTopic))
    engine.start()
    engine
  }
}
