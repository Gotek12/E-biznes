package models

import play.api.libs.json.Json

import java.sql.Date

case class Order(id: Long, userId: Long, status: Int, items: Int, createdAt: Date, tax: Float, price: BigDecimal, shipping: Float, payed: Boolean, realized: Boolean)

object Order {
  implicit val orderFormat = Json.format[Order]
}