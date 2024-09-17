package cloudcode.helloworld.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/** Defines a controller to handle HTTP requests */
@Controller
public final class HelloWorldController {

  private static String project;
  private static final Logger logger = LoggerFactory.getLogger(HelloWorldController.class);

  /**
   * Create an endpoint for the landing page
   *
   * @return the index view template
   */
  @GetMapping("/")
  public String helloWorld(Model model) {

    // Get Cloud Run environment variables.
    String revision = System.getenv("K_REVISION") == null ? "???" : System.getenv("K_REVISION");
    String service = System.getenv("K_SERVICE") == null ? "???" : System.getenv("K_SERVICE");

    // Set variables in html template.
    model.addAttribute("revision", revision);
    model.addAttribute("service", service);
    return "login";
  }

  @RequestMapping("/dashboard")
  public String index() {
    return "index";
  }

  @RequestMapping("/admin")
  public String admin() {
    return "admin";
  }

  @RequestMapping("/categories")
  public String categories() {
    return "categories";
  }

  @RequestMapping("/comment")
  public String comment() {
    return "comment";
  }

  @RequestMapping("/foodRecipe")
  public String foodRecipe() {
    return "foodRecipe";
  }

  @RequestMapping("/login")
  public String login() {
    return "login";
  }

  @RequestMapping("/user")
  public String user() {
    return "user";
  }

  @RequestMapping("/resetPassword")
  public String resetPassword() {
    return "resetPassword";
  }
}
