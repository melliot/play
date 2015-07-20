package controllers;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.Model;
import models.Person;
import play.*;
import play.api.db.DB;
import play.data.Form;
import play.mvc.*;

import views.html.*;

import java.util.List;

import static play.libs.Json.toJson;

public class Application extends Controller {

    public Result index() {
        return ok(index.render("Your new application is ready."));
    }

    public Result addPerson() {
        Person person = Form.form(Person.class).bindFromRequest().get();
        person.save();

        return redirect(routes.Application.index());
    }

    public Result getPerson() {

        List<Person> personList = Ebean.find(Person.class).findList();

        return ok(toJson(personList));
    }

    public Result deletePerson() {

        String name = Form.form(String.class).bindFromRequest().get();

        Person person = Ebean.find(Person.class).where().eq("name", name).findUnique();

        Ebean.delete(person);

        return redirect(routes.Application.index());
    }

}
