package controllers

import play.api.mvc._

import javax.inject._
import scala.concurrent.{ExecutionContext, Future}

@Singleton
class ProductReviewController @Inject()(cc: MessagesControllerComponents)(implicit ec: ExecutionContext) extends MessagesAbstractController(cc) {

  def addProductReview(): Action[AnyContent] = Action {
    NoContent
  }

  def getProductReviews: Action[AnyContent] = Action.async { implicit request =>
    Future {
      Ok("")
    }
  }

  def getProductReview(id: Long): Action[AnyContent] = Action.async { implicit request =>
    Future {
      Ok("")
    }
  }

  def deleteProductReview(id: Long): Action[AnyContent] = Action {
    NoContent
  }

  def updateProductReview(id: Long): Action[AnyContent] = Action.async { implicit request: MessagesRequest[AnyContent] =>
    Future {
      Ok("")
    }
  }

}