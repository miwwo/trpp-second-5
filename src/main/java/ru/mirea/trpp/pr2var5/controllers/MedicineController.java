package ru.mirea.trpp.pr2var5.controllers;

import com.opencsv.bean.CsvToBeanBuilder;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import ru.mirea.trpp.pr2var5.entity.Medicine;

import java.io.InputStreamReader;
import java.util.List;
import java.util.Optional;

/** ���������� ��� ������ � �������������. */
@Controller("/medicine")
public class MedicineController {

    /** ������ ������������. */
    private final List<Medicine> medicineList;

    /** �����������. */
    public MedicineController() {
        medicineList = new CsvToBeanBuilder<Medicine>(new InputStreamReader(
                this.getClass().getResourceAsStream("/MOCK_DATA.csv")
        )).withType(Medicine.class).build().parse();
    }

    /**
     * �������� ������ ������������.
     * @return ������ ������������
     */
    @Get()
    public HttpResponse<List<Medicine>> getMedicine() {
        return HttpResponse.ok(medicineList);
    }

    /**
     * ����� ����������� �� ��������������.
     * @param id ������������� ������������
     * @return �����������, ���� ����, ����� 404 ������
     */
    @Get("/{id}")
    public HttpResponse<Medicine> findById(Long id) {
        Optional<Medicine> result = medicineList.stream().filter(it -> it.getId().equals(id)).findAny();
        if (result.isPresent()) {
            return HttpResponse.ok(result.get());
        } else {
            return HttpResponse.notFound();
        }
    }
}
