package models

import play.api.db.slick.DatabaseConfigProvider
import slick.driver.JdbcProfile

import java.sql.Date
import javax.inject.{Inject, Singleton}
import scala.concurrent.{ExecutionContext, Future}

@Singleton
class UserPaymentRepository @Inject()(dbConfigProvider: DatabaseConfigProvider)(implicit ec: ExecutionContext) {
  val dbConfig = dbConfigProvider.get[JdbcProfile]

  import dbConfig._
  import profile.api._

  class  UserPaymentTable(tag: Tag) extends Table[UserPayment](tag, "userPayment") {
    def id = column[Long]("id", O.PrimaryKey, O.AutoInc)
    def userId = column[Long]("userId")
    def paymentType = column[String]("paymentType")
    def provider = column[String]("provider")
    def accountNumber = column[String]("accountNumber")
    def expiry = column[Date]("expiry")
    def * = (id, userId, paymentType, provider, accountNumber, expiry) <> ((UserPayment.apply _).tupled, UserPayment.unapply)
  }

  val userPay = TableQuery[UserPaymentTable]

  def list(): Future[Seq[UserPayment]] = db.run {
    userPay.result
  }

  def delete(id: Long): Future[Unit] = db.run(userPay.filter(_.id === id).delete).map(_ => ())

  def getById(id: Long): Future[UserPayment] = db.run {
    userPay.filter(_.id === id).result.head
  }

  def update(id: Long, newElement: UserPayment): Future[Unit] = {
    val toUpdate: UserPayment = newElement.copy(id)
    db.run(userPay.filter(_.id === id).update(toUpdate)).map(_ => ())
  }

  def create(userId: Long, paymentType: String, provider: String, accountNumber: String, expiry: Date): Future[UserPayment] = db.run {
    (userPay.map(el => (el.userId, el.paymentType, el.provider, el.accountNumber, el.expiry))
      returning userPay.map(_.id)
      into {case ((userId, paymentType, provider, accountNumber, expiry),id) => UserPayment(id, userId, paymentType, provider, accountNumber, expiry)}
      ) += (userId, paymentType, provider, accountNumber, expiry)
  }
}
