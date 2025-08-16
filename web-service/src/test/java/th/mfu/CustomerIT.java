// package th.mfu;

// import static org.junit.jupiter.api.Assertions.assertEquals;

// import java.time.LocalDate;

// import javax.ws.rs.client.Client;
// import javax.ws.rs.client.ClientBuilder;
// import javax.ws.rs.client.Entity;
// import javax.ws.rs.client.Invocation.Builder;
// import javax.ws.rs.core.Response;

// import org.junit.jupiter.api.BeforeAll;
// import org.junit.jupiter.api.Test;

// public class CustomerIT {

//     private static Client client;

//     @BeforeAll
//     public static void createClient() {
//         client = ClientBuilder.newClient();
//     }

//     @Test
//     public void testCreateCustomer() {
//         Customer customer = new Customer();
//         customer.setName("John Denver");
//         customer.setAddress("123 Main st.");
//         customer.setEmail("john@email.com");
//         customer.setPhone("0688888888");
//         customer.setBirthday(LocalDate.of(2002, 5, 6));

//         Builder builder = client.target("http://localhost:8080/customers").request();
//         Response response = builder.post(Entity.json(customer));
//         assertEquals(Response.Status.CREATED.getStatusCode(), response.getStatus());
//     }
// }


