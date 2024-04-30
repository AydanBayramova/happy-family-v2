package dao;

import dao.entity.Family;
import dao.FamilyDao;

import java.util.List;

public class CollectionFamilyDao implements FamilyDao {
    private List<Family> families;

    public CollectionFamilyDao(List<Family> families) {
        this.families = families;
    }

    @Override
    public List<Family> getAllFamilies() {
        return families;
    }

    @Override
    public Family getFamilyByIndex(int index) {
        if (index >= 0 && index < families.size()) {
            return families.get(index);
        } else {
            throw new IllegalArgumentException("Invalid index");
        }
    }

    @Override
    public boolean deleteFamily(int index) {
        if (index >= 0 && index < families.size()) {
            families.remove(index);
            return true;
        } else {
            throw new IllegalArgumentException("Invalid index");
        }
    }

    @Override
    public boolean deleteFamily(Family family) {
        if (family != null && families.contains(family)) {
            return families.remove(family);
        } else {
            throw new IllegalArgumentException("Family not found or null");
        }
    }

    @Override
    public boolean saveFamily(Family family) {
        if (family == null) {
            throw new IllegalArgumentException("Family object cannot be null");
        }

        int index = families.indexOf(family);
        if (index != -1) {
            families.set(index, family);
        } else {
            families.add(family);
        }
        return true;
    }

}
