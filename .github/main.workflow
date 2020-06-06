# .github/main.workflow
workflow "Merge master branch into develop upon successful PR to master" {
  resolves = ["Auto-merge to develop"]
  on       = "check_run"
}

action "Auto-merge to develop" {
  uses = "./auto_merge_to_develop"
}
