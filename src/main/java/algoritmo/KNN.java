package algoritmo;

import java.util.List;

public interface KNN {
    void train(lectura.TableWithLabels data);
    Double estimate(List<Double> data);
}
