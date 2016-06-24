package controllers

import javax.inject.Inject

import org.sedis.Pool
import play.api.mvc.{Action, Controller}

/**
  * @author auldanov
  */
class RestController @Inject()(sedisPool: Pool) extends Controller {
  def get(key: String) = Action {
    val data = sedisPool.withJedisClient(client => client.get(key))

    if (data != null) Ok(data) else NoContent
  }
}