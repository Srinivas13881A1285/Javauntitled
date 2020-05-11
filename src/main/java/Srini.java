public class Srini {
        public static void main(String[] args) {

            String arr[]={
                    "TomTom",
                    "EverBridge",
                    "Church & Dwight Co Inc",
                    "Argo Group International Holdings Ltd.",
                    "Tire Discounters",
                    "TTEC ",
                    "AmeriHome Mortgage Company",
                    "EnvisionRxOptions",
                    "Stanford Health Care",
                    "HomeLight",
                    "Mount Carmel Health",
                    "Jumbo Supermarkten",
                    "DekaMarkt",
                    "DetailResult Group",
                    "Dirk",
                    "Xperience Restaurant Group",
                    "ClearCapital.com, Inc.",
                    "Baylor Scott & White Health",
                    "Qualtrics",
                    "Technical Needs North",
                    "Valet Living",
                    "Cable One, Inc."
            };
            for(int i=0;i<arr.length;i++) {
                String originalCompanyName = arr[i];
                String compNameWithNoSplChars = originalCompanyName.replaceAll("[^a-zA-Z0-9 ]", "");
                String[] splitWords = compNameWithNoSplChars.split(" ");
                String refNum = "P_";
                if (splitWords.length > 1) {
                    int count = 0;
                    for (String s : splitWords) {
                        if (s != null && !s.equals("")) {
                            refNum += s.length() >=2 ? s.substring(0, 2).toUpperCase() : s.toUpperCase();
                            count += 1;
                            if (count == 2)
                                break;
                        }
                    }
                } else
                    refNum += compNameWithNoSplChars.length() >= 4 ? compNameWithNoSplChars.substring(0, 4).toUpperCase() : compNameWithNoSplChars.toUpperCase();
                refNum = refNum + "_" + originalCompanyName.length();
                System.out.println(refNum);
            }
        }
    }
