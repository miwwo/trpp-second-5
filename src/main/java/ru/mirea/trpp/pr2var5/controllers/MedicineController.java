package ru.mirea.trpp.pr2var5.controllers;

import com.opencsv.bean.CsvToBeanBuilder;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import ru.mirea.trpp.pr2var5.entity.Medicine;

import java.io.InputStreamReader;
import java.util.List;
import java.util.Optional;

/** Контроллер для работы с медикаментами. */
@Controller("/medicine")
public class MedicineController {

    /** Список медикаментов. */
    private final List<Medicine> medicineList;

    /** Конструктор. */
    public MedicineController() {
        medicineList = new CsvToBeanBuilder<Medicine>(new InputStreamReader(
                this.getClass().getResourceAsStream("/MOCK_DATA.csv")
        )).withType(Medicine.class).build().parse();
    }

    /**
     * Получить список медикаментов.
     * @return список медикаментов
     */
    @Get()
    public HttpResponse<List<Medicine>> getMedicine() {
        return HttpResponse.ok(medicineList);
    }

    /**
     * Найти медикаменты по идентификатору.
     * @param id идентификатор медикаментов
     * @return Медикаменты, если есть, иначе 404 ошибка
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
