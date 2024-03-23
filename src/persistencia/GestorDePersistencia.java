package persistencia;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import modelo.Usuario;

import java.io.*;
import java.lang.reflect.Type;
import java.util.*;

public class GestorDePersistencia {

    private static final String RUTA_ARCHIVO_USUARIOS = "usuarios.json";
    private Gson gson = new Gson();

    public void guardarUsuarios(List<Usuario> usuarios) {
        try (Writer writer = new FileWriter(RUTA_ARCHIVO_USUARIOS)) {
            Type listOfUsuariosType = new TypeToken<List<Usuario>>() {}.getType();
            gson.toJson(usuarios, listOfUsuariosType, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Usuario> cargarUsuarios() {
        try (Reader reader = new FileReader(RUTA_ARCHIVO_USUARIOS)) {
            Type listOfUsuariosType = new TypeToken<List<Usuario>>() {}.getType();
            return gson.fromJson(reader, listOfUsuariosType);
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}
