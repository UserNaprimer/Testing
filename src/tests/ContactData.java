package tests;

public class ContactData implements Comparable <ContactData> {

    public String first_name;
    public String second_name;
    public String address;
    public String email;

    public ContactData(String first_name, String second_name, String address, String email) {
    }

    public ContactData() {
    };

    @Override
    public String toString() {
        return "ContactData[" +
                "first_name='" + first_name + '\'' +
                ", second_name='" + second_name + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ']';
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime*result + ((second_name==null) ? 0 : second_name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;

        ContactData other = (ContactData) obj;
        if(second_name == null){
            if (other.second_name != null) return false;}
        else if (!second_name.equals(other.second_name)) return false;
        return true;
    }

    @Override
    public int compareTo(ContactData other) {
        return this.second_name.toLowerCase().compareTo(other.second_name.toLowerCase());
    }
}