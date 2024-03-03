package basics.service;

public class ExecuteGenerics {
    public static void main(String[] args) {
        GenericApi<Profile> profileGenericAPI=new GenericApi<>();
        GenericApi<DebitCard> debitCardGenericAPI=new GenericApi<>();
        GenericApi<Integer> integerGenericAPI=new GenericApi<>();

        profileGenericAPI.myObjects=new Profile[3];

        Profile profile1=new Profile("shreya","shreyam","Bhanshankari,BLR",876545678987L);
        Profile profile2=new Profile("pooja","poojar","BLR",567876567876L);
        Profile profile3=new Profile("ramya","ramyarai","manglore",987654567656L);
        Profile profile4=new Profile("kavya","kavyamite","BLR",456787654678L);

        System.out.println(profileGenericAPI.insertNewRecord(profile1));
        System.out.println(profileGenericAPI.insertNewRecord(profile2));
        System.out.println(profileGenericAPI.insertNewRecord(profile3));
        System.out.println(profileGenericAPI.insertNewRecord(profile4));

        System.out.println(profileGenericAPI.delete(1));
        System.out.println(profileGenericAPI.insertNewRecord(profile4));

        integerGenericAPI.myObjects=new Integer[]{67,12,56,78,2,35,78,7,95,3};

        integerGenericAPI.viewAll();

        System.out.println(integerGenericAPI.read(3));

        integerGenericAPI.update(9,120);

        integerGenericAPI.viewAll();

    }
}
