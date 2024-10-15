package airlines.pojo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Airline {
    private int id;
    private String name;
    private String country;
    private String logo;
    private String slogon;
    private String head_quaters;
    private String wesite;
    private String established;
}
