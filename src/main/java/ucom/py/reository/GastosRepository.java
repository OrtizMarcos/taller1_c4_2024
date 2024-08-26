package ucom.py.reository;

import ucom.py.config.GenericDAO;
import ucom.py.entities.apiresponse.Gastos;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class GastosRepository implements GenericDAO<Gastos, Integer> {

    private static final String FILE_PATH = "src/main/resources/gastos.json";
    private static final Json gson = new Json();

    // Cargar la lista de gastos desde el archivo JSON
    private List<Gastos> cargarDatos() {
        try (Reader reader = new FileReader(FILE_PATH)) {
            Type listType = new TypeToken<List<Gastos>>() {}.getType();
            return gson.fromJson(reader, listType);
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    // Guardar la lista de gastos en el archivo JSON
    private void guardarDatos(List<Gastos> gastos) {
        try (Writer writer = new FileWriter(FILE_PATH)) {
            gson.toJson(gastos, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Gastos> listar() {
        return cargarDatos();
    }

    @Override
    public Gastos obtener(Integer id) {
        List<Gastos> gastosList = cargarDatos();
        // Asumiendo que "id" representa la posición en la lista (índice)
        if (id >= 0 && id < gastosList.size()) {
            return gastosList.get(id);
        }
        return null;
    }

    @Override
    public Gastos modificar(Gastos param) {
        List<Gastos> gastosList = cargarDatos();
        // Se busca un objeto en la lista que coincida (por ejemplo, por fecha o descripción)
        for (int i = 0; i < gastosList.size(); i++) {
            Gastos gasto = gastosList.get(i);
            // Modifica según alguna lógica de identificación (e.g., descripción)
            if (gasto.getDescripcion().equals(param.getDescripcion())) {
                gastosList.set(i, param); // Reemplaza el objeto
                guardarDatos(gastosList); // Guarda la lista modificada
                return param;
            }
        }
        return null;
    }

    @Override
    public Gastos agregar(Gastos param) {
        List<Gastos> gastosList = cargarDatos();
        gastosList.add(param);
        guardarDatos(gastosList); // Guarda la lista actualizada
        return param;
    }

    @Override
    public void eliminar(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'eliminar'");
    }
}
