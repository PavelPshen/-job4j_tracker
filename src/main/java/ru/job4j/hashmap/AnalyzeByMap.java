package ru.job4j.hashmap;

import java.util.*;

public class AnalyzeByMap {

    public static double averageScore(List<Pupil> pupils) {
        int countSubject = 0;
        double sumScore = 0D;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                countSubject++;
                sumScore += subject.score();
            }
        }
        return sumScore / countSubject;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> result = new ArrayList<>();
        int countSubject = 0;
        double sumScore = 0D;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                countSubject++;
                sumScore += subject.score();

            }
            result.add(new Label(pupil.name(), sumScore / countSubject));
            sumScore = 0;
            countSubject = 0;
        }
        return result;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        Map<String, Integer> map = new LinkedHashMap<>();
        List<Label> result = new ArrayList<>();
        int sumScore = 0;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                map.put(subject.name(), map.getOrDefault(subject.name(), 0) + subject.score());
            }
        }
        for (String linked : map.keySet()) {
            result.add(new Label(linked, map.get(linked) / pupils.size()));
        }
        return result;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> result = new ArrayList<>();
        double sumScore = 0D;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                sumScore += subject.score();

            }
            result.add(new Label(pupil.name(), sumScore));
            sumScore = 0;
        }
        result.sort(Comparator.naturalOrder());
        return result.get(result.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        Map<String, Integer> linkedHashMap = new LinkedHashMap<>();
        List<Label> result = new ArrayList<>();
        int sumScore;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                if (linkedHashMap.get(subject.name()) != null) {
                    sumScore = linkedHashMap.get(subject.name());
                    linkedHashMap.put(subject.name(), sumScore + subject.score());
                } else {
                    linkedHashMap.put(subject.name(), subject.score());
                }
            }
        }
        for (String linked : linkedHashMap.keySet()) {
            result.add(new Label(linked, linkedHashMap.get(linked)));
        }
        result.sort(Comparator.naturalOrder());
        return result.get(result.size() - 1);
    }
}