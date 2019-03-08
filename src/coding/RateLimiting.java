package coding;

//you can also use imports, for example:
import java.util.*;

//you can write to stdout for debugging purposes, e.g.
//System.out.println("this is a debug message");

class Solution {

	class Request {
		String client;
		int timestamp;

		Request(String client, int timestamp) {
			this.client = client;
			this.timestamp = timestamp;
		}

		public int getTimestamp() {
			return this.timestamp;
		}

		public String getClient() {
			return this.client;
		}
	}

	public List<Request> sortArray(String[] A) {
		List<Request> inputA = new ArrayList<Request>();
		for (String s : A) {
			inputA.add(new Request(s.split(" ")[0], Integer.parseInt(s.split(" ")[1])));
		}
		Comparator<Request> cc = new Comparator<Request>() {
			@Override
			public int compare(Request first, Request other) {
				if (first.getTimestamp() != other.getTimestamp()) {
					return first.getTimestamp() - other.getTimestamp();
				} else {
					return first.getClient().compareTo(other.getClient());
				}
			}
		};

		Collections.sort(inputA, cc);
		for (Request r : inputA) {
			System.out.println(r.getClient() + " " + r.getTimestamp());

		}
		return inputA;
	}

	int previousWindow = 0;
	Map<String, Integer> totalClientRequests = new HashMap<String, Integer>();
	int totalRequests;
	String blockedClient;
	int blockingWindowCount;

	public String[] solution(String[] A, int Y) {
		// write your code in Java SE 8
		List<Request> inputA = sortArray(A);
		Map<String, Integer> allowedClientRequests;
		Map<Integer, Map<String, Integer>> requestsPerWindow = new HashMap<Integer, Map<String, Integer>>();
		Queue<Integer> windowQueue = new LinkedList<Integer>();
		// Part2

		for (Request r : inputA) {
			int windowIndex = r.getTimestamp() / 60;
			if (r.getClient().equals(blockedClient) && previousWindow != windowIndex) {
				blockingWindowCount--;
				if (blockingWindowCount == 0) {
					blockedClient = "";
				}
				continue;
			}
			if (null == requestsPerWindow.get(windowIndex)) {
				allowedClientRequests = new HashMap<String, Integer>();
			} else {
				allowedClientRequests = requestsPerWindow.get(windowIndex);
			}

			allowedClientRequests.put(r.getClient(), allowedClientRequests.getOrDefault(r.getClient(), 0) + 1);
			if (allowedClientRequests.get(r.getClient()) > Y) {
				allowedClientRequests.put(r.getClient(), allowedClientRequests.getOrDefault(r.getClient(), 0) - 1);
			}

			requestsPerWindow.put(windowIndex, allowedClientRequests);
			if (!windowQueue.contains(windowIndex)) {
				windowQueue.offer(windowIndex);
			}
			if (windowQueue.size() == 5) {
				checkForBlacklisting(windowQueue, requestsPerWindow);
			} else {
				for (String client : allowedClientRequests.keySet()) {
					totalClientRequests.put(client, totalClientRequests.getOrDefault(client, 0) + 1);
					totalRequests++;
				}
			}
			previousWindow = windowIndex;
		}
		for (int i = 0; i < 60; i++) {
			if (requestsPerWindow.get(i) != null) {
				Map<String, Integer> map = requestsPerWindow.get(i);
				System.out.println("For window=" + i);
				for (String client : map.keySet()) {
					System.out.println(client + " " + map.get(client));
				}
			}
		}
		String[] result = new String[totalClientRequests.keySet().size()];
		int pos = 0;
		for (String client : totalClientRequests.keySet()) {
			result[pos++] = client + " " + totalClientRequests.get(client);
		}
		return result;
	}

	public void checkForBlacklisting(Queue<Integer> queue, Map<Integer, Map<String, Integer>> requestsPerWindow) {
		for (int windowIndex : queue) {
			Map<String, Integer> allowedClientRequests = requestsPerWindow.get(windowIndex);
			for (String client : allowedClientRequests.keySet()) {
				totalClientRequests.put(client, 0);
				totalRequests = 0;
			}
			for (String client : allowedClientRequests.keySet()) {

				totalClientRequests.put(client, totalClientRequests.getOrDefault(client, 0) + 1);
				totalRequests++;
			}
			for (String client : totalClientRequests.keySet()) {
				if (totalClientRequests.get(client) > totalRequests / 2 && totalRequests > 10) {
					blockingWindowCount = 2;
					blockedClient = client;
					totalClientRequests.put(client, totalRequests / 2);
				}
			}
		}
		queue.poll();
	}
}
