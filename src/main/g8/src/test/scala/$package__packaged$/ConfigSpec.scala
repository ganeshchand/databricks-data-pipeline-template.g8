package $organization$.$name;format="lower,word"$

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.must.Matchers

class ConfigSpec extends AnyFlatSpec with Matchers with TestHelper{
  it must "be able to load configurations from resources folder" in {
    val env = "dev"
    val deltalakeConf = Config.forEnv(env)
    deltalakeConf.raw mustBe "/deltalake/raw"
    deltalakeConf.cleansed mustBe "/deltalake/cleansed"
    deltalakeConf.consumption mustBe "/deltalake/consumption"
  }
}