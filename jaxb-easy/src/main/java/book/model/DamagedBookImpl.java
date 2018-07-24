package book.model;

import book.api.Book;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@Data
@NoArgsConstructor
@XmlRootElement(name = "book")
@XmlType(propOrder = {"damageIndex"})
public class DamagedBookImpl extends BookImpl {

    @XmlJavaTypeAdapter(DamageIndexIntAdapter.class)
    private DamageIndex damageIndex;

    public DamagedBookImpl(Book book, double damageIndex) {
        super(book);
        this.damageIndex = new DamageIndex(damageIndex);
    }

    @Override
    public String toString() {
        return "DamagedBook: " + super.toString() + " - damage index: " + damageIndex;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class DamageIndex {
        double damageIndex;
    }

    @NoArgsConstructor
    public static class DamageIndexIntAdapter extends XmlAdapter<Double, DamageIndex> {

        @Override
        public DamageIndex unmarshal(Double v) throws Exception {
            return new DamageIndex(v);
        }

        @Override
        public Double marshal(DamageIndex v) throws Exception {
            return v.damageIndex;
        }
    }
}
