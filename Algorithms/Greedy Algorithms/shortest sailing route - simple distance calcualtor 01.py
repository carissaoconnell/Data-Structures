# To celebrate the upcoming sailing olympics, I created a simple, playful calculator
# that uses Dijkstra's algorithm to find the shortest distance between each location.
# The calculator is meant to have fun playing with latitude and longitude locations and to demonstrate Dijkstra's algorithm


import math

def distance(lat1, lon1, lat2, lon2):
    R = 6371  # radius of the Earth in kilometers
    lat1, lon1, lat2, lon2 = map(math.radians, [lat1, lon1, lat2, lon2])
    dlat = lat2 - lat1
    dlon = lon2 - lon1
    a = math.sin(dlat/2)**2 + math.cos(lat1) * math.cos(lat2) * math.sin(dlon/2)**2
    c = 2 * math.atan2(math.sqrt(a), math.sqrt(1-a))
    return R * c

def dijkstra(graph, start):
    distances = {node: float('infinity') for node in graph}
    distances[start] = 0
    unvisited_nodes = list(graph.keys())
    current_node = start

    while unvisited_nodes:
        for neighbor, distance in graph[current_node].items():
            if distance + distances[current_node] < distances[neighbor]:
                distances[neighbor] = distance + distances[current_node]
        unvisited_nodes.remove(current_node)
        if not unvisited_nodes:
            break
        current_node = min([(distances[node], node) for node in unvisited_nodes])[1]

    return distances

current_location = [float(x) for x in input("Enter your current location (latitude, longitude): ").split(',')]
dest_location = [float(x) for x in input("Enter your desired destination (latitude, longitude): ").split(',')]
num_stops = int(input("Enter the number of stops: "))
stops = []
for i in range(num_stops):
    stop = [float(x) for x in input(f"Enter stop {i+1} location (latitude, longitude): ").split(',')]
    stops.append(stop)

total_distance = 0
current_location = tuple(current_location)
for i, stop in enumerate(stops + [dest_location]):
    graph = {}
    nodes = [current_location, tuple(stop)]
    for node in nodes:
        graph[node] = {}
        for neighbor in nodes:
            if node!= neighbor:
                graph[node][neighbor] = distance(node[0], node[1], neighbor[0], neighbor[1])
    print(f"Calculating shortest sailing route to stop {i+1}...")
    distance_to_stop = dijkstra(graph, current_location)[tuple(stop)]
    print(f"Shortest sailing distance: {distance_to_stop:.2f} kilometers")
    total_distance += distance_to_stop
    current_location = tuple(stop)

print(f"Total shortest sailing distance: {total_distance:.2f} kilometers")
