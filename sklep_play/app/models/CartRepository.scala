package models

import play.api.db.slick.DatabaseConfigProvider
import slick.driver.JdbcProfile

import java.sql.Date
import javax.inject.{Inject, Singleton}
import scala.concurrent.{ExecutionContext, Future}

@Singleton
class CartRepository @Inject() (dbConfigProvider: DatabaseConfigProvider)(implicit ec: ExecutionContext) {
  val dbConfig = dbConfigProvider.get[JdbcProfile]

  import dbConfig._
  import profile.api._

  class CartTable(tag: Tag) extends Table[Cart](tag, "cart") {
    def id = column[Long]("id", O.PrimaryKey, O.AutoInc)
    def userId = column[Long]("userId")
    def createdAt = column[Date]("createdAt")
    def * = (id, userId, createdAt) <> ((Cart.apply _).tupled, Cart.unapply)
  }

  val cart = TableQuery[CartTable]

  def list(): Future[Seq[Cart]] = db.run {
    cart.result
  }

  def delete(id: Long): Future[Unit] = db.run(cart.filter(_.id === id).delete).map(_ => ())

  def getById(id: Long): Future[Cart] = db.run {
    cart.filter(_.id === id).result.head
  }

  def update(id: Long, newElement: Cart): Future[Unit] = {
    val toUpdate: Cart = newElement.copy(id)
    db.run(cart.filter(_.id === id).update(toUpdate)).map(_ => ())
  }

  def create(userId: Int, createdAt: Date): Future[Cart] = db.run {
    (cart.map(el => (el.userId, el.createdAt))
      returning cart.map(_.id)
      into {case ((userId, createdAt),id) => Cart(id, userId, createdAt)}
      ) += (userId, createdAt)
  }
}
