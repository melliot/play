package controllers;

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
        List<Person> personList = new Model.Finder(String.class, Person.class).all();

        return ok(toJson(personList));
    }

    public Result deletePerson() {

        Person deletedPerson = Form.form(Person.class).bindFromRequest().get();

        List<Person> persons = new Model.Finder(String.class, Person.class).findIds();

        System.out.println(persons);

        return redirect(routes.Application.index());
    }
}
