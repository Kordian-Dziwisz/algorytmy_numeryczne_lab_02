library(jsonlite)

# Read the JSON file into R
results <- fromJSON("results.json")

# Extract the values from the inner dictionaries

for (name in names(results)) {
    hist(unlist(results[[name]]), main=name)
}