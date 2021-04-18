package controllers

import play.api.mvc._

import javax.inject._
import scala.concurrent.{ExecutionContext, Future}

@Singleton
class UserPaymentController @Inject()(cc: MessagesControllerComponents)(implicit ec: ExecutionContext) extends MessagesAbstractController(cc) {

  def addUserPayment(): Action[AnyContent] = Action {
    NoContent
  }

  def getUserPayments: Action[AnyContent] = Action.async { implicit request =>
    Future {
      Ok("")
    }
  }

  def getUserPayment(id: Long): Action[AnyContent] = Action.async { implicit request =>
    Future {
      Ok("")
    }
  }

  def deleteUserPayment(id: Long): Action[AnyContent] = Action {
    NoContent
  }

  def updateUserPayment(id: Long): Action[AnyContent] = Action.async { implicit request: MessagesRequest[AnyContent] =>
    Future {
      Ok("")
    }
  }

}