package pl.sdacademy.javapoz19programowanie1.pet;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class PetServiceTest {

    @Test
    public void findAllShouldReturnListOfPets(){

       List <Pet> testPets =  Arrays.asList(
                new Pet("pet-1",2 ,"A", "csa"),
                new Pet("pet-4",2 ,"S", "casaa"),
                new Pet("pet-2",3 ,"f", "csdsa"));

        PetService petService = new PetService(new InMemoryPetRepository(testPets));
        List<Pet> actualList = petService.findAll();

        Assert.assertEquals(testPets, actualList);
    }

    @Test
    public void findByBreedShouldReturnListOfPetsOfBreed(){
        List <Pet> testPets =  Arrays.asList(
                new Pet("pet-1",2 ,"A", "csa"),
                new Pet("pet-4",2 ,"S", "casaa"),
                new Pet("pet-2",3 ,"f", "csdsa"));

        PetService petService = new PetService(new InMemoryPetRepository(testPets));

        List<Pet> result = petService.findByBreed("A");

        Assert.assertEquals(1,result.size());
        Assert.assertEquals(new Pet("pet-1",2 ,"A", "csa"),result.get(0));
    }

    @Test
    public void findbyLocationShouldReturnListOfPetsOfLocation() {
        List<Pet> testPets = Arrays.asList(
                new Pet("pet-1", 2, "A", "csa"),
                new Pet("pet-4", 2, "S", "casaa"),
                new Pet("pet-2", 3, "f", "csdsa"));

        PetService petService = new PetService(new InMemoryPetRepository(testPets));

        List<Pet> result = petService.findByLocation("csa");

        Assert.assertEquals(1, result.size());
        Assert.assertEquals(new Pet("pet-1", 2, "A", "csa"), result.get(0));
    }

    @Test
    public void sortByAgeShouldReturnListSortedByAge(){
        List<Pet> testPets = Arrays.asList(
                new Pet("pet-1", 2, "A", "csa"),
                new Pet("pet-4", 1, "S", "casaa"),
                new Pet("pet-2", 3, "f", "csdsa"));
        PetService petService = new PetService(new InMemoryPetRepository(testPets));

        List <Pet> result = petService.sortByAge();

        Assert.assertEquals(result.get(0), testPets.get(1));
        Assert.assertEquals(result.get(1), testPets.get(0));
        Assert.assertEquals(result.get(2), testPets.get(2));

    }
    @Test
    public void groupByBreedShouldReturnMapWithGroupedPets(){
        PetService petService = new PetService(new InMemoryPetRepository());

        Map<String, List<Pet>> map = petService.groupByBreed();

        Assert.assertEquals(3,map.get("Scottish Terrier").size() );
        Assert.assertEquals(5,map.get("French Bulldog").size() );
        Assert.assertEquals(3,map.get("Boxer").size());
        Assert.assertEquals(5,map.get("Golden Retriever").size() );

    }
}
