package controllers

import play.api.mvc._

import javax.inject._
import scala.concurrent.{ExecutionContext, Future}

@Singleton
class UserAddressController @Inject()(cc: MessagesControllerComponents)(implicit ec: ExecutionContext) extends MessagesAbstractController(cc) {

  def addUserAddress(): Action[AnyContent] = Action {
    NoContent
  }

  def getUserAddresses: Action[AnyContent] = Action.async { implicit request =>
    Future {
      Ok("")
    }
  }

  def getUserAddress(id: Long): Action[AnyContent] = Action.async { implicit request =>
    Future {
      Ok("")
    }
  }

  def deleteUserAddress(id: Long): Action[AnyContent] = Action {
    NoContent
  }

  def updateUserAddress(id: Long): Action[AnyContent] = Action.async { implicit request: MessagesRequest[AnyContent] =>
    Future {
      Ok("")
    }
  }

}