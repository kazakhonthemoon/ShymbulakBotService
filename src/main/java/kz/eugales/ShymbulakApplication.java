package kz.eugales;



import com.google.gson.Gson;
import java.net.URI;
import java.util.logging.Level;
import java.util.logging.Logger;
import kz.eugales.pojo.UpdateResponse;
import kz.eugales.pojo.Result;
import kz.eugales.pojo.SendMessageResponse;
import kz.eugales.repository.ResultRepository;
import kz.eugales.util.Consts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication

public class ShymbulakApplication {

    public static void main(String[] args) throws Exception {
        ApplicationContext context = SpringApplication.run(ShymbulakApplication.class, args);

        MyBean bean = context.getBean(MyBean.class);
        
        Thread thread = new Thread(new Runnable() {

            
            

            @Override
            public void run() {

                String getUpdate = "getUpdates?offset=";
                String sendMessage = "sendMessage?chat_id=";

                RestTemplate rest = new RestTemplate();
                UpdateResponse updateResponse = null;
                String lastUpdateId = "0";

                while (true) {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(ShymbulakApplication.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    updateResponse = rest.getForObject(Consts.BASE_URL + getUpdate + lastUpdateId, UpdateResponse.class);

                    if (updateResponse != null && updateResponse.getOk().equals("true") && !updateResponse.getResult().isEmpty()) {
                        for (Result r : updateResponse.getResult()) {
                            lastUpdateId = r.getUpdateId();
                            Gson g = new Gson();
                            System.out.println(g.toJson(r));

                            SendMessageResponse sendMessageResponse = rest.getForObject(Consts.BASE_URL + sendMessage + r.getMessage().getChat().getId()
                                    + "&text=" + urlRequestsManager(r.getMessage().getText()),
                                    SendMessageResponse.class);

                        }
                        lastUpdateId = String.valueOf(Integer.parseInt(lastUpdateId) + 1);
                    }
                    /*else {
                        System.out.println("is empty");
                    }*/

                }
            }

            String urlRequestsManager(String url) {

                String result = "nothing";

                switch (url) {
                    case "/aainfo":
                        result = bean.getAainfo();
                        //System.out.println(result);
                        break;
                    case "/start":
                        result = bean.getAastart();
                        System.out.println(result);
                        break;
                    case "/about":
                        //result = bean.getProp();
                        //System.out.println(result);
                        break;
                    case "/news":
                        break;
                    case "/time":
                        break;
                    case "/services":
                        break;
                    case "/contests":
                        break;
                    case "/gallery":
                        break;
                    case "/howtofind":
                        break;
                    case "/contacts":
                        break;
                }
                return result;
            }

        });

        thread.start();
    }

}
