library(jsonlite)

# Read the JSON file into R
results <- fromJSON("results.json")

# Extract the values from the inner dictionaries

for (result in results) {
    hist(unlist(result))
}