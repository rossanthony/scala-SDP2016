package autoscan

import org.springframework.beans.factory.BeanFactory
import org.springframework.context.support.ClassPathXmlApplicationContext

object HelloWorldSpringWithAutoscan {
  @throws(classOf[Exception])
  def main(args: Array[String]) {
    val factory: BeanFactory = getBeanFactory
    val mr: MessageRenderer = factory.getBean("renderer").asInstanceOf[MessageRenderer]
    mr.render
  }

  @throws(classOf[Exception])
  private def getBeanFactory: BeanFactory = {
    new ClassPathXmlApplicationContext("autoscan.xml")
  }
}