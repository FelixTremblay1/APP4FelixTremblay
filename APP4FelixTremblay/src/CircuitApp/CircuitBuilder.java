package CircuitApp;

import Composant.CircuitSerie;
import Composant.CircuitParallele;
import Composant.Resistance;
import Composant.Composant;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.imageio.IIOException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class CircuitBuilder {
    CircuitBuilder() {

    }

    public Composant construireCircuit(String cheminFichier) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            JsonNode donnesComposantes = mapper.readTree(new File(cheminFichier));
            return lireComposant(donnesComposantes.get("circuit"));
        } catch (IOException e) {
            System.out.println("Erreur de lecture : " + e.getMessage());
        }finally{

        }
        return null;
    }

    private Composant lireComposant(JsonNode node) {
        String type = node.get("type").asText();

        if (type.equals("resistance")) {
            return new Resistance(node.get("valeur").asDouble());
        } else if (type.equals("parallele")) {
            ArrayList<Composant> composants = new ArrayList<>();
            for (JsonNode thingNode : node.get("composants")) {
                composants.add(lireComposant(thingNode));
            }
            return new CircuitParallele(composants);
        } else if (type.equals("serie")) {
            ArrayList<Composant> composants = new ArrayList<>();
            for (JsonNode thingNode : node.get("composants")) {
                composants.add(lireComposant(thingNode));
            }
            return new CircuitSerie(composants);
        }
        throw new IllegalArgumentException("Type de composante inconnue : " + type);
    }
}
