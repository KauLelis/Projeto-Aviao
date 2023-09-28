package Voo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

import Voo.Voo;

public class Reserva {

  public Voo voo;
  public Usuario usuario;
  public String status;
  public static Queue<Reserva> reservas_pendentes = new LinkedList<>();

  public Reserva(Voo voo){
    
    Scanner scn = new Scanner(System.in);
  
    System.out.println("\n".repeat(40));
  
    System.out.print("#".repeat(60));
  
    System.out.println("\n\nForneça as seguintes informações para realizar uma reserva\n");
  
    System.out.print("Nome: ");
    String nome = scn.nextLine();
  
    System.out.print("\nIdade: ");
    int idade = scn.nextInt();
  
    scn.nextLine();
    System.out.print("\nCPF: ");
    String CPF = scn.nextLine();
  
    System.out.print("\ne-mail: ");
    String email = scn.nextLine();
  
    Usuario user = new Usuario(nome, idade, CPF, email);
    
    this.voo = voo;
    this.usuario = user;
    this.status = "PENDENTE";
  }    

  public static void mostrarReservasPendentes(List<Voo> lista_voos){

    for(int i = 0; i < reservas_pendentes.size(); i++) {
      
      Reserva reserva = reservas_pendentes.element();

      System.out.println("\n".repeat(40));

      System.out.println("#".repeat(40));

      System.out.println("Número: " + reserva.voo.numero);
      System.out.println("Origem: " + reserva.voo.origem);
      System.out.println("Destino: " + reserva.voo.destino);
      System.out.println("Quantidade máxima de passageiros: " + reserva.voo.qtd_max_passageiros);
      System.out.println("Horário de partida: " + reserva.voo.horario_partida);
      System.out.println("Horário de chegada: " + reserva.voo.horario_chegada);

      System.out.println("#".repeat(40));

    }
    Scanner scn = new Scanner(System.in);
    System.out.println("[Digite 0 para voltar para o Menu]");
    String resposta = scn.nextLine();
    if(resposta.equals("0")) {
      Voo.mostrarVoos(lista_voos);
    }

  }
}