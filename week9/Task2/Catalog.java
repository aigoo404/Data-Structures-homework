package week9.Task2;

import java.util.*;

public class Catalog {
    private List<Publication> publications;

    public Catalog(List<Publication> publications) {
        this.publications = publications;
    }

    public List<Publication> getPublications() {
        return publications;
    }

    public void addPublication(Publication publication) {
        this.publications.add(publication);
    }

    public double getTotalPrice() {
        double sum = 0;
        for (Publication p : publications) {
            sum += p.getPrice();
        }
        return sum;
    }

    public ReferenceBook findLongestChapter() {
        ReferenceBook result = null;
        int maxPages = 0;
        for (Publication p : publications) {
            if (p.getType().equals("Reference Book")) {
                ReferenceBook refbook = (ReferenceBook) p;
                for (Chapter c : refbook.getChapters()) {
                    if (c.getPages() > maxPages) {
                        maxPages = c.getPages();
                        result = refbook;
                    }
                }
            }
        }
        return result;
    }

    public boolean containsMagazine(String name) {
        for (Publication p : publications) {
            if (p.getType().equals("Magazine")) {
                Magazine mag = (Magazine) p;
                if (mag.getMagazineName().equals(name)) {
                    return true;
                }
            }
        }
        return false;
    }

    public List<Magazine> getMagazinesByYear(int year) {
        List<Magazine> result = new ArrayList<>();
        for (Publication p : publications) {
            if (p.getType().equals("Magazine") && p.getYear() == year) {
                Magazine mag = (Magazine) p;
                result.add(mag);
            }
        }
        return result;
    }

    public void sortPublications() {
        Collections.sort(publications, new Comparator<Publication>() {
            @Override
            public int compare(Publication p1, Publication p2) {
                int comparedTitle = p1.getTitle().compareTo(p2.getTitle());
                if (comparedTitle != 0) {
                    return comparedTitle;
                } else {
                    return Integer.compare(p2.getYear(), p1.getYear());
                }
            }
        });
    }

    public Map<Integer, Integer> countPublicationsByYear() {
        Map<Integer, Integer> countByYear = new HashMap<>();
        for (Publication p : publications) {
            int year = p.getYear();
            if (countByYear.containsKey(year)) {
                countByYear.put(year, countByYear.get(year) + 1);
            } else {
                countByYear.put(year, 1);
            }
        }
        return countByYear;
    }
}
