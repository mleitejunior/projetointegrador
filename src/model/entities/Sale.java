package model.entities;

import model.structure.Tax;
import model.structure.Discount;
import java.util.Calendar;

public class Sale {
    private Integer id;
    private Calendar date;
    private Enum type;
    private Discount discount;
    private Tax tax;
    private Product products[];
}
