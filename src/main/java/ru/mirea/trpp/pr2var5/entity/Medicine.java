package ru.mirea.trpp.pr2var5.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.opencsv.bean.CsvBindByName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/** Сущность медикаментов. */
@Getter
@Setter
@ToString
public class Medicine {

    /** Идентификатор. */
    @JsonProperty("id")
    @CsvBindByName(column = "id")
    private Long id;
    /** Наименование. */
    @JsonProperty("name")
    @CsvBindByName(column = "name")
    private String name;
    /** Действующее вещество. */
    @JsonProperty("generic")
    @CsvBindByName(column = "generic")
    private String generic;
    /** Производитель. */
    @JsonProperty("vendor")
    @CsvBindByName(column = "vendor")
    private String vendor;
    /** Код FDA. */
    @JsonProperty("fda_code")
    @CsvBindByName(column = "fda_code")
    private String fdaCode;


}
