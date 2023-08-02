
package atm;


import java.util.Scanner;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Mohamed MOstafa
 */
public class ATM extends Application{
   
     @Override
    public void start(Stage primaryStage) throws Exception {
        Scanner ip = new Scanner(System.in);
        Text txt = new Text("Choose one option");
       
        txt.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR,30));
        txt.setFill(Color.ORANGERED);
        HBox hbb = new HBox();
        hbb.getChildren().add(txt);
        hbb.setAlignment(Pos.TOP_CENTER);
        hbb.setStyle("-fx-padding: 30 0 0 0");
        Button bt1 = new Button("Check balance");
        bt1.setFont(Font.font(18));
        bt1.setStyle("-fx-background-color: orange");
        Button bt2 = new Button("withdraw");
        bt2.setFont(Font.font(18));
        bt2.setStyle("-fx-background-color: orange");
        Button bt3 = new Button("deposite");
        bt3.setFont(Font.font(18));
        bt3.setStyle("-fx-background-color: orange");
        VBox vb = new VBox();
       
        HBox hb1 =  new HBox();
        Balance balance = new Balance(1244);
        EventHandler<MouseEvent>eventBalance = new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event) {
                Stage stage4 = new Stage();
                Text txt2 = new Text("Now, your balance is : "+balance.getBalance());
                txt2.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
                txt2.setFill(Color.WHITE);
                HBox hbTx = new HBox();
                hbTx.getChildren().addAll(txt2);
                hbTx.setAlignment(Pos.CENTER);
                hbTx.setStyle("-fx-padding: 100;");
                Button bt = new Button("close");
                bt.setMinWidth(30);
                bt.setFont(Font.font(20));
                bt.setStyle("-fx-background-color: orange");
                HBox hbBt = new HBox();
                hbBt.getChildren().add(bt);
                hbBt.setStyle("-fx-padding: 100 0 0 40;");
                StackPane st = new StackPane();
                VBox vb = new VBox();
                vb.getChildren().addAll(hbTx,hbBt);
                vb.setSpacing(40);
                st.getChildren().add(vb);
              
                EventHandler<MouseEvent>eventClose = new EventHandler<MouseEvent>(){
                    @Override
                    public void handle(MouseEvent event) {
                       stage4.close();
                    }
            
                };
                st.setStyle("-fx-background-color:black;");
                Scene scene = new Scene(st,600,600);
                
                stage4.setTitle("Balance");
                stage4.setScene(scene);

                stage4.show();
                bt.addEventHandler(MouseEvent.MOUSE_CLICKED, eventClose);
            }
            
        };
        hb1.getChildren().add(bt1);
       
        HBox hb2 =  new HBox();
         EventHandler<MouseEvent>eventWithdraw = new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event) {
//                System.out.print("Enter the amount that you want to withdraw: ");
//                int with = ip.nextInt();
//                Withdraw withdraw = new Withdraw(with);
//                balance.decreaseBalacance(withdraw);
                Stage stage2 = new Stage();
                Text txt2 = new Text("Enter amount to withdraw : ");
                txt2.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
                txt2.setFill(Color.WHITE);
                TextField userText = new TextField();
                HBox hbTx = new HBox();
                hbTx.getChildren().addAll(txt2,userText);
                hbTx.setSpacing(20);
                hbTx.setStyle("-fx-padding: 100 0 0 40;");
                Button bt = new Button("Ok");
                bt.setMinWidth(30);
                bt.setFont(Font.font(20));
                bt.setStyle("-fx-background-color: orange");
                HBox hbBt = new HBox();
                hbBt.getChildren().add(bt);
                hbBt.setStyle("-fx-padding: 100 0 0 40;");
                StackPane st = new StackPane();
                VBox vb = new VBox();
                vb.getChildren().addAll(hbTx,hbBt);
                vb.setSpacing(40);
                st.getChildren().add(vb);
              
                EventHandler<MouseEvent>eventOk = new EventHandler<MouseEvent>(){
                    @Override
                    public void handle(MouseEvent event) {
                        String with = userText.getText();
                        Withdraw withdraw = new Withdraw(Integer.valueOf(with));
                        balance.decreaseBalacance(withdraw);
                        if(balance.isFlag() == false){
                            Stage stage3 = new Stage();
                            Text tx = new Text("Sorry, can't withdraw this amount!!");
                            tx.setFill(Color.ORANGERED);
                            HBox hbWith = new HBox();
                            hbWith.getChildren().add(tx);
                            hbWith.setAlignment(Pos.CENTER);
                            //close button
                            Button btt = new Button("Close");
                            HBox hbBTT = new HBox();
                            hbBTT.getChildren().add(btt);
                            btt.setStyle("-fx-background-color: orange");
                            btt.setMinWidth(40);
                            hbBTT.setStyle("-fx-padding: 100 0 0 40;");
                            VBox vb2 = new VBox();
                            vb2.getChildren().addAll(hbWith,hbBTT);
                            vb2.setSpacing(40);
                            
                            EventHandler<MouseEvent>eventClose = new EventHandler<MouseEvent>() {
                                @Override
                                public void handle(MouseEvent event) {
                                    balance.setFlag(true);
                                    stage3.close();
                                }
                            };
                            
                            vb2.setStyle("-fx-background-color: black;"+"-fx-padding: 50 0 0 0");
                            Scene scene = new Scene(vb2,300,300);
                            
                            stage3.setTitle("Warning");
                            stage3.setScene(scene);

                            stage3.show();
                            btt.addEventHandler(MouseEvent.MOUSE_CLICKED, eventClose);
                            
                        }else{
                             stage2.close();
                        }
                       
                    }
            
                };
                st.setStyle("-fx-background-color:black;");
                Scene scene = new Scene(st,600,600);
                
                stage2.setTitle("Withdraw");
                stage2.setScene(scene);

                stage2.show();
                bt.addEventHandler(MouseEvent.MOUSE_CLICKED, eventOk);
                
            }
            
        };
        
        hb2.getChildren().add(bt2);
        HBox hb3 =  new HBox();
          EventHandler<MouseEvent>eventDeposite = new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event) {
//                System.out.print("Enter the deposite: ");
//                int dep = ip.nextInt();
//                Deposite deposite = new Deposite(dep);
//                balance.increaseBalance(deposite);
                Stage stage1 = new Stage();
                Text txt2 = new Text("Enter Deposite : ");
                txt2.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
                txt2.setFill(Color.WHITE);
                TextField userText = new TextField();
                HBox hbTx = new HBox();
                hbTx.getChildren().addAll(txt2,userText);
                hbTx.setSpacing(20);
                hbTx.setStyle("-fx-padding: 100 0 0 40;");
                Button bt = new Button("Ok");
                bt.setMinWidth(40);
                bt.setFont(Font.font(20));
                bt.setStyle("-fx-background-color: orange");
                HBox hbBt = new HBox();
                hbBt.getChildren().add(bt);
                hbBt.setStyle("-fx-padding: 100 0 0 40;");
                StackPane st = new StackPane();
                VBox vb = new VBox();
                vb.getChildren().addAll(hbTx,hbBt);
                vb.setSpacing(40);
                st.getChildren().add(vb);
              
                EventHandler<MouseEvent>eventOk = new EventHandler<MouseEvent>(){
                    @Override
                    public void handle(MouseEvent event) {
                       String dep = userText.getText();
                       Deposite deposite = new Deposite(Integer.valueOf(dep));
                       balance.increaseBalance(deposite);
                       stage1.close();
                    }
            
                };
                st.setStyle("-fx-background-color:black;");
                Scene scene = new Scene(st,600,600);
                
                stage1.setTitle("Deposite");
                stage1.setScene(scene);

                stage1.show();
                bt.addEventHandler(MouseEvent.MOUSE_CLICKED, eventOk);
            }
            
        };
        
        hb3.getChildren().add(bt3);
        vb.setAlignment(Pos.BASELINE_CENTER);
        vb.setStyle("-fx-padding: 100;");
       
        vb.getChildren().addAll(hb1,hb2,hb3);
        vb.setSpacing(50);
        StackPane st = new StackPane();
        
        st.getChildren().addAll(hbb,vb);
        st.setStyle("-fx-background-color: black;" );
        Scene scene = new Scene(st,600,600);
        bt1.addEventHandler(MouseEvent.MOUSE_CLICKED, eventBalance);
        bt2.addEventHandler(MouseEvent.MOUSE_CLICKED, eventWithdraw);
        bt3.addEventHandler(MouseEvent.MOUSE_CLICKED, eventDeposite);
        primaryStage.setTitle("ATM");
        primaryStage.setScene(scene);

        primaryStage : primaryStage.show();
        
        
        
    }
    public static void main(String[] args) {
        launch(args);
    }

   
    
}
