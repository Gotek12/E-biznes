
package models

import play.api.libs.json.Json

import java.sql.Date


case class User(id: Long, nick: String, firstName: String, lastName: String, email: String, password: String, registeredAt: Date, lastLogin: Date)

object User {
  implicit val userFormat = Json.format[User]
}