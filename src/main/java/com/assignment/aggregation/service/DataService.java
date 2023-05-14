package com.assignment.aggregation.service;
import com.assignment.aggregation.BananaCase;
import com.assignment.aggregation.CRMCase;
import com.assignment.aggregation.StrawberryCase;
import com.assignment.aggregation.service.CaseService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import javax.cache.Cache;

@Service
public class DataService {

    @Autowired
    private CaseService caseService;

    // The URLs that simulate the CRM systems
    private final String URL1 = "https://example.com/data1";
    private final String URL2 = "https://example.com/data2";
    @Autowired
    private final RestTemplate restTemplate;
    @Autowired
    private final Cache<String, Object> cache;
    private int refreshIntervalInHours = 4;

    @Autowired
    public DataService(RestTemplate restTemplate, Cache<String, Object> cache) {
        this.restTemplate = restTemplate;
        this.cache = cache;
    }

    @Scheduled(fixedDelay = 10000) // 10 seconds
    public void fetchDataFromUrls() {

        String[] ids = new String[numberOfObjects];
        for (int i = 0; i < numberOfObjects; i++) {
            ids[i] = Integer.toString(i + 1);
        }

        String[] codes = {"11111", "22222", "33333", "44444", "55555", "77777", "88888", "99999"};
        String[] providers = {"provider_1", "provider_2", "provider_3"};
        int[] statuses = {404, 300, 500};
        String[] states = {"Open", "Closed"};
        String[] colors = {"Blue", "Green", "Red"};

        List<CRMCase> crmCaseList = new ArrayList<CRMCase>();
        for (String id : ids) {
            String code = codes[(int) (Math.random() * codes.length)];
            String provider = providers[(int) (Math.random() * providers.length)];
            int status = statuses[(int) (Math.random() * statuses.length)];
            String state = states[(int) (Math.random() * states.length)];
            String date1 = Instant.now().toString();
            String date2 = Instant.now().toString();
            String color = colors[(int) (Math.random() * colors.length)];

            BananaCase bananaCase = new BananaCase(id, code, provider, status, state, date1, date2, color);
            StrawberryCase strawberryCase = new StrawberryCase(id, code, provider, status, state, date1, date2, color);

            crmCaseList.add(bananaCase);
            crmCaseList.add(strawberryCase);
        }

        caseService.addCases(crmCaseList);
    }

    private int numberOfObjects = 10;

    public void setNumberOfObjects(int numberOfObjects) {
        this.numberOfObjects = numberOfObjects;
    }
}

