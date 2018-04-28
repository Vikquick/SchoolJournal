package Models.ENUM;

import javax.xml.bind.annotation.XmlEnum;

@XmlEnum
public enum AssesmentEn {
    TWO {
        @Override
        public String toString() {
            return "2";
        }
    },
    THREE {
        @Override
        public String toString() {
            return "3";
        }
    },
    FOUR {
        @Override
        public String toString() {
            return "4";
        }
    },
    FIVE {
        @Override
        public String toString() {
            return "5";
        }
    };

    @Override
    public abstract String toString();
}