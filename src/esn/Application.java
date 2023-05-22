package esn;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import esn.data.*;


public class Application {

    public static void main(String[] args) throws Exception {

        ESN esn = new ESN();
        ManagerClient mc = esn.getManagerClient();
        ManagerProjet mp = esn.getManagerProjet();
        ManagerEmploye me = esn.getManagerEmploye();
        //ManagerDepartement md = esn.getManagerDepartement();

        esn.debuter();

        // création de projets
        Projet p1 = mp.ajouterProjet("Paye", LocalDate.of(2022, 10, 05), LocalDate.of(2023, 12, 31));
        Projet p2 = mp.ajouterProjet("RH", LocalDate.of(2021, 04, 05), LocalDate.of(2022, 10, 25));
        Projet p3 = mp.ajouterProjet("ERP", LocalDate.of(2022, 06, 04), LocalDate.of(2024, 11, 20));


        // création des clients
        Client c1 = mc.ajouterClient("Roos", "Jean-François", "jean-francois.roos@univ-lille.fr", "Auchan", "Chef de projet", "218218");
        Client c2 = mc.ajouterClient("Bogaert", "Bruno", "bruno.bogaert@univ-lille.fr", "Crédit Agricole", "DSI", "208208");
        Client c3 = mc.ajouterClient("Salvati", "Sylvain", "sylvai.salvati@univ-lille.fr", "Decathlon", "Directeur commercial", "210210");
        Client c4 = mc.ajouterClient("Décallonne", "Marc", "marc.decallonne@univ-lille.fr", "OVH", "Exploitation", "118118");

        // création des employes
        Employe e1 = me.ajouterEmploye("Salengro", "Roger", "roger.salengro.etu@univ-lille.fr", LocalDate.of(2018, 11, 10), 1900.0f);
        Employe e2 = me.ajouterEmploye("Rouve", "Jean-Paul", "jean-paul.rouve.etu@univ-lille.fr", LocalDate.of(2014, 6, 20), 200.0f);
        Employe e3 = me.ajouterEmploye("Mittenaere", "Iris", "iris.mittrnaere.etu@univ-lille.fr", LocalDate.of(1016, 1, 10), 3900.0f);


        // associer projets et employes
        mp.affecterEmploye(p1, e3);
        mp.affecterEmploye(p2, e2);
        mp.affecterEmploye(p3, e2);
        mp.affecterEmploye(p3, e1);
        mp.affecterEmploye(p1, e2);
        mp.affecterEmploye(p2, e1);

        // associer projets et clients
        mp.gererParClient(p3, c4);
        mp.gererParClient(p2, c4);
        mp.gererParClient(p1, c2);

      esn.valider();

      esn.debuter();

      List<Projet> lp = mp.lesProjets();
      for(Projet p : lp) {
    	  
          System.out.println("client responsable du projet : "+ p.getClient());
          // afficher le client responsable du projet

          // afficher les différents employes affectes au projet
          System.out.println("\tEmployes :"+ p.getEmployes());

      }

      esn.valider();
     }
}

