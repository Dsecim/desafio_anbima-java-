import java.util.Scanner;
import java.io.*;
import java.text.NumberFormat;
import java.util.Locale;
public class calc_irpf{
    public static void main(String[] args){
          Locale localeBR = new Locale("pt","BR");
          Scanner inputr = new Scanner(System.in);
          System.out.print("entre com a renda bruta:");
          double renda= inputr.nextDouble();
          System.out.print("entre com o num de dependentes:");
          Scanner input = new Scanner(System.in);
          int  num_dep= input.nextInt();
          String nome="daniela";
          double aliquota1=0.0;
          double aliquota2=0.0;
          double v_max=642.34;
          if(renda<=1751.81){
              aliquota1=(renda*8)/100;
          }else{
              if(renda>1751.81 && renda<=2919.72){
                aliquota1=(renda*9)/100;
              }else{
                if(renda>2919.72 && renda<=5839.45) {
                        aliquota1=(renda*11)/100;
                }else{
                        aliquota1= v_max;
                }
              }
          }
          double imp_inss=aliquota1;
          double desconto_dep=189.59*num_dep;
          double aux1=renda-(aliquota1+desconto_dep);
          if(aux1<=1903.98){
                aliquota2=(aux1*0);
          }else{
                if(aux1>1903.98 && aux1<=2826.65){
                        aliquota2=aux1*0.075;
                        aliquota2=aliquota2-142.80;
                }else{
                        if(aux1>2826.65 && aux1<=3751.06){
                                aliquota2=aux1*0.15;
                                aliquota2=aliquota2-354.80;
                        }else{
                                if(aux1>3751.06 && aux1<=4664.68){
                                        aliquota2= aux1*0.225;
                                        aliquota2=aliquota2-639.13;
                                }else{
                                        aliquota2= aux1*0.275;
                                        aliquota2= aliquota2-869.36;
                                }
                        }
                }
        }
        double imp_irpf=aliquota2;
        double desconto_total=aliquota1+aliquota2;
        double sal_final=renda-desconto_total;
        NumberFormat dinheiro = NumberFormat.getCurrencyInstance(localeBR);
        System.out.println("valor do imposto inss:"+dinheiro.format(imp_inss));
        System.out.println("valor do imposto irpf:"+dinheiro.format(imp_irpf));
        System.out.println("valor do desconto totalR$:"+dinheiro.format(desconto_total));
        System.out.println("valor do salario final:R$"+dinheiro.format(sal_final));
  }


}
