package ru.mirea.trpp.pr2var5.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.opencsv.bean.CsvBindByName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/** �������� ������������. */
@Getter
@Setter
@ToString
public class Medicine {

    /** �������������. */
    @JsonProperty("id")
    @CsvBindByName(column = "id")
    private Long id;
    /** ������������. */
    @JsonProperty("name")
    @CsvBindByName(column = "name")
    private String name;
    /** ����������� ��������. */
    @JsonProperty("generic")
    @CsvBindByName(column = "generic")
    private String generic;
    /** �������������. */
    @JsonProperty("vendor")
    @CsvBindByName(column = "vendor")
    private String vendor;
    /** ��� FDA. */
    @JsonProperty("fda_code")
    @CsvBindByName(column = "fda_code")
    private String fdaCode;


}
