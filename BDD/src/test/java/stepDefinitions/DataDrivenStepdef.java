package stepDefinitions;

import java.util.List;
import java.util.Map;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.When;

public class DataDrivenStepdef {
	@When("user want to fill the registration form")
	public void user_want_to_fill_the_registration_form(DataTable dataTable) {
	   List<List<Object>> data = dataTable.asLists(Object.class);
	  System.out.println(data.get(0).get(0));
	  System.out.println(data.get(0).get(1));
	  System.out.println(data.get(0).get(2));
	  System.out.println(data.get(0).get(3));
	}

	@When("user want to fill the registration form in application")
	public void user_want_to_fill_the_registration_form_in_application(DataTable dataTable) {
	    List<Map<Object, Object>> data = dataTable.asMaps(Object.class, Object.class);
	    System.out.println(data.get(0).get("username"));
	    System.out.println(data.get(0).get("email"));
	    System.out.println(data.get(0).get("password"));
	    System.out.println(data.get(0).get("phNo"));
	}

}
