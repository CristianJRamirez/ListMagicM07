package sample;

/**
 * Created by 45858000w on 28/10/16.
 */
public class Carta {
    public String name;
    public String manaCost;
    public String type;
    public String colors;
    public String rarity;
    public String text;
    public String power;
    public String imageUrl;
  /*  public String
    public String
    public String*/

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManaCost() {
        return manaCost;
    }

    public void setManaCost(String manaCost) {
        this.manaCost = manaCost;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getColors() {
        return colors;
    }

    public void setColors(String colors) {
        this.colors = colors;
    }

    public String getRarity() {
        return rarity;
    }

    public void setRarity(String rarity) {
        this.rarity = rarity;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "Carta {" +
                "name='" + name + '\'' +
                ", manaCost='" + manaCost + '\'' +
                ", type='" + type + '\'' +
                ", colors='" + colors + '\'' +
                ", rarity='" + rarity + '\'' +
                ", text='" + text + '\'' +
                ", power='" + power + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}

