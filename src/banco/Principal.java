package banco;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

public class Principal {


    public static void main(String[] args) throws Exception {

        int i = 1;
        boolean appBanco = true;
        Conta contas[] = new Conta[10];
        HashMap<Integer, Conta> contaHashMap = new HashMap<>();
        contaHashMap.put(1, new ContaCorrente(1, 2, "Banco ", 1000.00, 100.00));
        contaHashMap.put(2, new ContaSalario(2,2,"Banco ", 1500.00, "Mentorama"));
        contaHashMap.put(3, new ContaPoupanca(3,3,"Banco", 100.00,18, 0.05));
        contaHashMap.put(4, new ContaCorrente(4,2, "Banco", 100.00, 100.00));
        contaHashMap.put(5, new ContaSalario(5,2,"Banco", 1500.00,"Kotlin Ltda."));
        contaHashMap.put(6, new ContaCorrente(6, 2, "Banco", 100.00, 1000.00));
        contaHashMap.put(7, new ContaPoupanca(7,1,"Banco", 9000.00,30,0.02));
        contaHashMap.put(8, new ContaInvestimento(8,5,"Banco",10000.00,"Fundo mentorama", 0.5,0.05));

        Date data = new Date();
        SimpleDateFormat formatador = new SimpleDateFormat("dd");
        int dataAtual =  Integer.parseInt(formatador.format(data));

        contas[0] = contaHashMap.get(1);
        contas[1] = contaHashMap.get(2);
        contas[2] = contaHashMap.get(3);
        contas[3] = contaHashMap.get(4);
        contas[4] = contaHashMap.get(5);
        contas[5] = contaHashMap.get(6);
        contas[6] = contaHashMap.get(7);
        contas[7] = contaHashMap.get(8);

         double resultado = contas[0].getSaldo() + contas[1].getSaldo() + contas[2].getSaldo() + contas[3].getSaldo() +
                 contas[4].getSaldo() + contas[5].getSaldo() + contas[6].getSaldo() + contas[7].getSaldo() + contas[8].getSaldo();






        while (appBanco) {

            Scanner opcoesBanco = new Scanner(System.in);


        System.out.println("Bem vindo ao sistema BANCO");
        System.out.println("Digite a opção desejada");
        System.out.println("0 - Sacar");
        System.out.println("1 - Depositar");            
        System.out.println("2 - Ver saldo"); 
        System.out.println(" 3 - Criar Conta");      
        System.out.println("4 - Transferir valores"); 
        System.out.println("5 - Mostrar montante no Banco"); 
        System.out.println("6 - Sair");
                       
                
        int menu = opcoesBanco.nextInt();


            switch (menu) {
                case 0:
                    System.out.println("Introduza o numero da conta: ");
                    Conta conta = contas[opcoesBanco.nextInt()];
                    System.out.println("Insira o valor do saque usando vírgulas");
                    conta.setSaque(opcoesBanco.nextDouble());
                   System.out.println("O saldo atual é R$" + conta.getSaque());
                    break;
                case 1:
                    System.out.println("Introduza o numero da conta: ");
                    conta = contas[opcoesBanco.nextInt()];
                  System.out.println("Insira o valor do depósito usando vírgulas");
                    conta.setDeposito(opcoesBanco.nextDouble());
                   System.out.println("O saldo atual é R$" + conta.getDeposito());
                    break;
                case 2:
                    System.out.println("Introduza o numero da conta: ");
                    conta = contas[opcoesBanco.nextInt()];
                    System.out.println("O seu saldo é de: R$" + conta.getSaldo());
                    break;
                case 3:
                    registroConta();
                    break;
                case 4:
                    System.out.println("Introduza o numero da conta A: ");
                    conta = contas[opcoesBanco.nextInt()];
                    System.out.println("Introduza o numero da conta B: ");
                    Conta conta1 = contas[opcoesBanco.nextInt()];
                    conta.getTransferencia();
                    conta1.getTransferencia();
                    break;
                case 5:
                    System.out.println("O banco atualmente possui: R$" + resultado);

                case 6:
                    System.out.println("♔ Volte sempre, majestade, ♔ \n ♔ Aqui somos sempre seus súditos, Grupo Banco Rei ♔");
                    appBanco = false;
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + menu);
            }
        }
    }

    public static void registroConta() {
        ArrayList<Conta> tipoConta = new ArrayList<>();



        Scanner novaConta = new Scanner(System.in);
        System.out.println("Escolha o tipo da conta que voce quer criar:");
        System.out.println("1 - Conta Corrente");
        System.out.println("2 - Conta Poupança");
        System.out.println("3 - Conta Salário");
               
        int registro = novaConta.nextInt();
        switch (registro){
            
            case 1:
                System.out.println(" Insira nessa sequência: 1 - Numero da conta \n");
                int id = novaConta.nextInt();
                System.out.println("2 - Numero da agencia");
                int ag = novaConta.nextInt();
                System.out.println("3 - Saldo Incial");
                double s = novaConta.nextDouble();
                System.out.println("4 -Insira o cheque especial contratado");
                double p = novaConta.nextDouble();
                tipoConta.add(new ContaCorrente(id , ag, "Banco Rei", s, p));
                System.out.println(tipoConta);
                break;
            case 2:
                System.out.println(" Insira nessa sequência: 1 - Numero da conta \n");
                id = novaConta.nextInt();
                System.out.println("2 - Numero da agencia");
                ag = novaConta.nextInt();
                System.out.println("3 - Saldo Incial");
                s = novaConta.nextDouble();
                System.out.println("4 - Qual o dia de rendimento da conta");
                int d = novaConta.nextInt();
                System.out.println("5 -Insira a taxa de juros contratada");
                p = novaConta.nextDouble();
                tipoConta.add(new ContaPoupanca(id , ag, "Banco Rei", s, d, p));
                System.out.println(tipoConta);
                break;
            case 3:
                System.out.println(" Insira nessa sequência: 1 - Numero da conta \n");
                id = novaConta.nextInt();
                System.out.println("2 - Numero da agencia");
                ag = novaConta.nextInt();
                System.out.println("3 - Saldo Incial");
                s = novaConta.nextDouble();
                System.out.println("4 -Insira o nome do seu empregador");
                String e = novaConta.nextLine();
                tipoConta.add(new ContaSalario(id , ag, "Banco Rei", s, e));
                System.out.println(tipoConta);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + registro);
        }
    }
}
