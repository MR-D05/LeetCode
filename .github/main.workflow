# .github/main.workflow
workflow "Merge branch if pull request is successful" {
  resolves = ["Auto-merge"]
  on       = "check_run"
}

action "Auto-merge" {
  uses = "./auto_merge"
  secrets = ["GITHUB_TOKEN"]
}
