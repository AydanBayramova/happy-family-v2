package dao;

import dao.entity.Family;
import dao.FamilyDao;

import java.util.List;

public class CollectionFamilyDao implements FamilyDao {
    private  List<Family> families;

    public CollectionFamilyDao(List<Family> families) {
        this.families = families;
    }

    @Override
    public List<Family> getAllFamilies() {
        return families;
    }

    @Override
    public Family getFamilyByIndex(int index) {
        if (index>=0 && index<families.size()){
            return families.get(index);
        }
        else {
            return null;
        }
    }



    @Override
    public boolean deleteFamily(int index) {
        if (index>=0 && index<families.size()){
            families.remove(index);
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public boolean deleteFamily(Family family) {
        int index=families.indexOf(family);
        if (index!=-1){
            families.remove(index);
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public boolean saveFamily(Family family) {
        int index=families.indexOf(family);
        if (index!=-1){
            families.set(index,family);
        }else {
            families.add(family);
        }
        return true;
    }



}
